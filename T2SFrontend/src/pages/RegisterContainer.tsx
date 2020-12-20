import React, { FormEvent, useState } from 'react';
import { Link, useHistory } from 'react-router-dom';
import api from '../config/api';

interface Container {
    client: string;
    cntr: string;
    typeContainer: string;
    category: string;
    status: string;
}

export default function RegisterContainer() {
    const history = useHistory();
    const [client, setClient] = useState("");
    const [cntr, setCntr] = useState("");
    const [typeContainer, setTypeContainer] = useState("");
    const [category, setCategory] = useState("");
    const [status, setStatus] = useState("");


    async function saveData(event: FormEvent) {
        event.preventDefault();
        const data: Container = {
            client: client,
            cntr: cntr,
            typeContainer: typeContainer,
            category: category,
            status: status
        }
        try {
            await api.post("containers", data);
            alert("saved");
            history.push('/containers')
        } catch (e) {
            alert("Error!!! ");
        }
        console.log(data);
    }

    return (
        <div>
            <Link to="/containers">Back</Link>
            <h1>Register Container</h1>
            <form action="" onSubmit={saveData}>
                <input placeholder="Client" onChange={e => setClient(e.target.value)} type="text" />
                <input placeholder="CNTR (ex aaaa1234567)" onChange={e => setCntr(e.target.value)} type="text" />

                <select name="Container Type" onChange={e => setTypeContainer(e.target.value)} id="">
                    <option value="">Tipo De Container</option>
                    <option value="T20">T20</option>
                    <option value="T40">T40</option>
                </select>

                <select name="Category" defaultValue="" onChange={e => setCategory(e.target.value)} id="">
                    <option value="">Categoria</option>
                    <option value="IMPORT">IMPORT</option>
                    <option value="EXPORT">EXPORT</option>
                </select>

                <select name="Status" defaultValue="T40" onChange={e => setStatus(e.target.value)} id="">
                    <option value="">Status</option>
                    <option value="FULL">FULL</option>
                    <option value="EMPTY">EMPTY</option>
                </select>

                
                
                <input type="submit" value="Register" />
            </form>
        </div>
    )
}