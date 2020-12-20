import React from 'react'
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import Landing from './pages/Landing';
import Containers from './pages/Containers'
import EditContainer from './pages/EditContainer'
import EditMovement from './pages/EditMovement'
import Movements from './pages/Movements'
import RegisterContainer from './pages/RegisterContainer'
import RegisterMovement from './pages/RegisterMovement'

export default function Routes() {
    return (
        <BrowserRouter>
            <Switch>
                <Route path="/" exact component={Landing} />
                <Route path="/containers" component={Containers} />
                <Route path="/container/create" component={RegisterContainer} />  
                <Route path="/container/:id" component={EditContainer} />
                  
                <Route path="/movements" component={Movements} />
                <Route path="/movement/create" component={RegisterMovement} />
                <Route path="/movement/:id" component={EditMovement} />
            </Switch>
        </BrowserRouter>
    );
}