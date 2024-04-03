import React, { useState } from 'react'
import CompanyService from '../sevices/CompanyService';
import { useNavigate } from 'react-router-dom';

export const RegisterProductComponent = () => {

    const [code, setCode] = useState('');
    const [name, setName] = useState('');
    const [description, setDescription] = useState('');
    const navigate = useNavigate();

    const saveProduct = (e) => {
        e.preventDefault();
        const product = { code, name, description}
        CompanyService.createProduct(product).then((Response) => {
            console.log(Response.data);
            navigate('/list-product');
        }).catch(error => {
            console.log(error)
        })

    }
    const cancelProduct = (e) => {
       
            navigate('/list-product');
       
    }

    return (
        <div className='container'>
            <div className='row'>
                <div className='card col-md-6 offset-md-3 offset-md-3'>
                    <hr></hr>
                    <h2 className='text-center'>Register product</h2>
                    <div className='card-body'></div>
                    <form>
                        <div className='form-group mb-2'>
                            <label className='form-label'>Code</label>
                            <input
                                type='text'
                                placeholder='enter your code'
                                name='code'
                                className='form-control'
                                value={code}
                                onChange={(e) => setCode(e.target.value)}
                            />
                        </div>
                        <div className='form-group mb-2'>
                            <label className='form-label'>Name</label>
                            <input
                                type='text'
                                placeholder='enter your name'
                                name='name'
                                className='form-control'
                                value={name}
                                onChange={(e) => setName(e.target.value)}
                            />
                        </div>
                        <div className='form-group mb-2'>
                            <label className='form-label'>Description</label>
                            <input
                                type='text'
                                placeholder='enter your description'
                                name='description'
                                className='form-control'
                                value={description}
                                onChange={(e) => setDescription(e.target.value)}
                            />
                        </div>
                        
                        
                        <button className='btn btn-success' onClick={(e) => saveProduct(e)} >Save</button>
                        &nbsp;&nbsp;
                        <button className='btn btn-danger' onClick={(e) => cancelProduct(e)} >Cancel</button>
                        
                        
                    </form>
                </div>
            </div>
        </div>
    )
}

export default RegisterProductComponent;
