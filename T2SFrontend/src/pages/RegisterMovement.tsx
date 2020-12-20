import React, { FormEvent, useState } from 'react';
import { Link, useHistory } from 'react-router-dom';
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

export default function RegisterMovement() {
    const history = useHistory();
    const [containerId, seContainerId] = useState("");
    const [ship, setShip] = useState("");
    const [handling, setHandling] = useState("");
    const [timestart, setTimeStart] = useState("");
    const [timeend, setTimeEnd] = useState("");


    async function saveData(event: FormEvent) {
        event.preventDefault();
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
            await api.post("movements", data);
            alert("saved");
            history.push('/movements')
        } catch (e) {
            alert("Error!!! ");
        }
        console.log(data);
    }

    return (
        <div>
            <Link to="/movements">Back</Link>
            <h1>Register Movement</h1>
            <form action="" onSubmit={saveData}>
                <input placeholder="ID Container" onChange={e => seContainerId(e.target.value)} type="number" />
                <input placeholder="Ship" onChange={e => setShip(e.target.value)} type="text" />
               

                <select name="Handling" onChange={e => setHandling(e.target.value)} id="">
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
                <input type="datetime-local" placeholder="inicio" name="Data Inicio" id="" onChange={e => setTimeStart(e.target.value)}/>
                <label htmlFor="">fim</label>
                <input type="datetime-local" placeholder="inicio" name="Data fim" id="" onChange={e => setTimeEnd(e.target.value)}/>
                <input type="submit" value="Register" />
            </form>
        </div>
    )
}