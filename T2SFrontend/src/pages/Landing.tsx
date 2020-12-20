import React from 'react';
import {Link} from 'react-router-dom';

export default function Landing() {
    return(
        <div>
            <Link to="/containers">  Containers  </Link>
            <Link to="/movements">  Movements  </Link>
            <a href="http://localhost:8080/movementreport"> RELATORY </a>
        </div>
    )
        
    
}