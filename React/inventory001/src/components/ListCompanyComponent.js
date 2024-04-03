import React, { useEffect, useState } from 'react'
import CompanyService from '../sevices/CompanyService';
import { Link } from 'react-router-dom';

export const ListCompanyComponent = () => {

    const [companys, setCompanys] = useState([]);

    useEffect(() => {
        CompanyService.getCompanyAll().then(Response => {
            setCompanys(Response.data);
            console.log(Response.data);

        }).catch(error => {
            console.log(error);
        })
    }, [])

    return (
        <div className='container'>
            <h2 className='text-center'> List companys</h2>
            <Link to='/register-company' className='btn btn-primary mb-2'> Register company</Link>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <Link to='/list-product' className='btn btn-primary mb-2'> Products</Link>
            
            <table className='table table-bordered table-striped'>
                <thead>
                    <th>NIT</th>
                    <th>NAME COMPANY</th>
                    <th>ADDRESS</th>
                    <th>PHONE</th>
                </thead>
                <tbody>
                    {
                        companys.map(
                            company =>
                                <tr key={company.nit}>
                                    <td>{company.nit}</td>
                                    <td>{company.name}</td>
                                    <td>{company.address}</td>
                                    <td>{company.phone}</td>
                                </tr>
                        )
                    }

                </tbody>
            </table>
            <Link to='/' className='btn btn-danger mb-2'> Logout</Link>
            
        </div>
    )
}

export default ListCompanyComponent
