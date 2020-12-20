import React, { FormEvent, useState } from 'react';
import { useEffect } from 'react';
import { Link, useHistory, useParams } from 'react-router-dom';
import api from '../config/api';

interface Container {
    client: string;
    cntr: string;
    typeContainer: string;
    category: string;
    status: string;
}

interface ContainerParams {
    id: string;
  }

export default function EditContainer() {

    const history = useHistory();
    const [client, setClient] = useState("");
    const [cntr, setCntr] = useState("");
    const [typeContainer, setTypeContainer] = useState("");
    const [category, setCategory] = useState("");
    const [status, setStatus] = useState("");
    const [container,setContainer] = useState<Container>();
    const params = useParams<ContainerParams>();
    useEffect(() => {
        api.get('containers/'+params.id).then(response => {
            setContainer(response.data);
            setClient(response.data.client);
            setCntr(response.data.cntr);
            setTypeContainer(response.data.typeContainer);
            setCategory(response.data.category);
            setStatus(response.data.status);

        })
    }, []);


    async function updateData(event: FormEvent) {
        event.preventDefault();
        const data: Container = {
            client: client,
            cntr: cntr,
            typeContainer: typeContainer,
            category: category,
            status: status
        }
        try{
            await api.put("containers/"+params.id,data);
            alert("updated");
            history.push('/containers')
        }catch(e){
            alert("Error!!! "+e);
        }
        console.log(data);
    }

    return (
        <div>
            <Link to="/containers">Back</Link>
            <h1>Update Container</h1>
            <form action="" onSubmit={updateData}>
            <input placeholder="Client" defaultValue={client} onChange={e => setClient(e.target.value)} type="text" />
                <input placeholder="CNTR (ex aaaa1234567)" defaultValue={cntr} onChange={e => setCntr(e.target.value)} type="text" />

                <select name="Container Type" value={typeContainer} onChange={e => setTypeContainer(e.target.value)} id="">
                    <option value="">Tipo De Container</option>
                    <option value="T20">T20</option>
                    <option value="T40">T40</option>
                </select>

                <select name="Category" value={category} onChange={e => setCategory(e.target.value)} id="">
                    <option value="">Categoria</option>
                    <option value="IMPORT">IMPORT</option>
                    <option value="EXPORT">EXPORT</option>
                </select>

                <select name="Status" value={status} onChange={e => setStatus(e.target.value)} id="">
                    <option value="">Status</option>
                    <option value="FULL">FULL</option>
                    <option value="EMPTY">EMPTY</option>
                </select>
                <input type="submit" value="Update Item"/>
            </form>
        </div>
    )
}