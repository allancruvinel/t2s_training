import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import api from '../config/api';

interface Container {
    id: number;
    client: string;
    cntr: string;
    typeContainer: string;
    category: string;
    status: string;
}

export default function Containers() {

    const [containers, setContainers] = useState<Container[]>([])

    useEffect(() => {
        api.get('containers').then(response => {
            setContainers(response.data);
        })
    }, []);

    async function deleteContainer(id: any) {
        try {
            await api.delete(`containers/${id}`);
            alert("Container Deleted")
            window.location.reload();
        } catch (e) {
            alert("ERROR " + e);
        }
    }


    return (
        <div>
            <Link to="/">______Index______</Link>
            <Link to="/container/create">New Container</Link>
            {

                containers.map(container => {
                    return (
                        <div>
                            <Link key={`${container.id}`} to={`/container/${container.id}`}>
                                <p>Id {`${container.id}`} Client {`${container.client}`} <br /></p>

                            </Link>
                            <button onClick={() => deleteContainer(container.id)}>Delete</button>
                        </div>
                    )
                })
            }

        </div>
    )
}