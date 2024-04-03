import React, { useEffect, useState } from 'react'
import CompanyService from '../sevices/CompanyService';
import { Link } from 'react-router-dom';

export const ListProductComponent = () => {

    const [products, setProducts] = useState([]);

    useEffect(() => {
        CompanyService.getProductAll().then(Response => {
            setProducts(Response.data);
            console.log(Response.data);

        }).catch(error => {
            console.log(error);
        })
    }, [])

    return (
        <div className='container'>
            <h2 className='text-center'> List product</h2>
            <Link to='/register-product' className='btn btn-primary mb-2'> Register product</Link>
            
            <table className='table table-bordered table-striped'>
                <thead>
                    <th>NAME</th>
                    <th>DESCRIPTION</th>
                </thead>
                <tbody>
                    {
                        products.map(
                            product =>
                                <tr key={product.id}>
                                    <td>{product.id}</td>
                                    <td>{product.description}</td>
                                </tr>
                        )
                    }

                </tbody>
            </table>
            <Link to='/' className='btn btn-danger mb-2'> Logout</Link>
            
        </div>
    )
}

export default ListProductComponent;
