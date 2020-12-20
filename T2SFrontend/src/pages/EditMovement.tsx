import React, { FormEvent, useEffect, useState } from 'react';
import { Link, useHistory, useParams } from 'react-router-dom';
import moment from 'moment';
import api from '../config/api';

interface Movement {
    container: {
        id: string;
    }
    ship: string;
    handling: string;
    timestart: string;
    timeend: string;
}

interface MovementParams {
    id: string;
}

export default function EditMovement() {
    const history = useHistory();
    const [containerId, seContainerId] = useState("");
    const [ship, setShip] = useState("");
    const [handling, setHandling] = useState("");
    const [timestart, setTimeStart] = useState("");
    const [timeend, setTimeEnd] = useState("");
    const params = useParams<MovementParams>();

    useEffect(() => {
        api.get('movements/' + params.id).then(response => {
            seContainerId(response.data.container.id);
            setShip(response.data.ship)
            setHandling(response.data.handling);
            if(response.data.timestart !== null){
                setTimeStart(moment(response.data.timestart).format('YYYY-MM-DDTHH:mm'));
            }
            if(response.data.timestart !== null){
                setTimeEnd(moment(response.data.timeend).format('YYYY-MM-DDTHH:mm'));
            }
            
            

        })
    }, []);


    async function updateData(event: FormEvent) {
        event.preventDefault();
        alert("o valor é "+timestart);


        var myDate = new Date(timestart); // Your timezone!
        var myEpoch = myDate.getTime() / 1000.0;
        alert(myEpoch);

        const data: Movement = {
            container: {
                id: containerId
            },
            ship: ship,
            handling: handling,
            timestart: timestart,
            timeend: timeend,
        }
        try {
            await api.put("movements/" + params.id, data);
            alert("updated");
            history.push('/movements')
        } catch (e) {
            alert("Error!!! ");
        }
        console.log(data);
    }


    return (
        <div>
            <Link to="/movements">Back</Link>
            <h1>Update Movement</h1>
            <form action="" onSubmit={updateData}>
                <input placeholder="ID Container" value={containerId} onChange={e => seContainerId(e.target.value)} type="text" />
                <input placeholder="Ship" value={ship} onChange={e => setShip(e.target.value)} type="text" />
                <select name="Handling" value={handling} onChange={e => setHandling(e.target.value)} id="">
                    <option value="">Movimentacao</option>
                    <option value="BOARDING">BOARDING</option>
                    <option value="DISCHARGE">DISCHARGE</option>
                    <option value="GATE_IN">GATE_IN</option>
                    <option value="GATE_OUT">GATE_OUT</option>
                    <option value="STACK">STACK</option>
                    <option value="WEIGHING">WEIGHING</option>
                    <option value="SCANNER">SCANNER</option>
                </select>
                <label htmlFor="">Inicio</label>
                <input type="datetime-local" defaultValue={timestart} placeholder="inicio" name="Data Inicio" id="" onChange={e => setTimeStart(e.target.value)} />
                <label htmlFor="">fim</label>
                <input type="datetime-local" defaultValue={timeend} placeholder="inicio" name="Data fim" id="" onChange={e => setTimeEnd(e.target.value)} />
                <input type="submit" value="Update" />
            </form>
        </div>
    )
}