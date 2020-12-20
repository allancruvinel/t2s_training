import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import api from '../config/api';

interface Movement {
    id: number;
    container: {
        id: number;
        client: string;
        cntr: string;
        typeContainer: string;
        category: string;
        status: string;
    }
    ship: string;
    handling: string;
    timestart: Date;
    timeend: Date;
}

export default function Movements() {

    const [movements, setMovements] = useState<Movement[]>([])

    useEffect(() => {
        api.get('movements').then(response => {
            setMovements(response.data);
        })
    }, []);

    async function deleteMovement(id: any) {
        try {
            await api.delete(`movements/${id}`);
            alert("Movement Deleted")
            window.location.reload();
        } catch (e) {
            alert("ERROR " + e);
        }
    }


    return (
        <div>
            <Link to="/">______Index______</Link>
            <Link to="/movement/create">New Movement</Link>
            {

                movements.map(movement => {
                    return (
                        <div>
                            <Link key={`${movement.id}`} to={`/movement/${movement.id}`}>
                                <p>Id:{`${movement.id}`}_____Handling:{`${movement.handling}`}_____Container Client:{`${movement.container.client}`}_____StartMovement:{`${movement.timestart}`}_____EndMovement:{`${movement.timeend}`} <br /></p>

                            </Link>
                            <button onClick={() => deleteMovement(movement.id)}>Delete</button>
                        </div>
                    )
                })
            }

        </div>
    )
}