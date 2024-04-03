import React, { useState } from 'react'
import CompanyService from '../sevices/CompanyService';
import { useNavigate } from 'react-router-dom';

export const RegisterCompanyComponent = () => {

    const [nit, setNit] = useState('');
    const [name, setName] = useState('');
    const [address, setAddres] = useState('');
    const [phone, setPhone] = useState('');
    const navigate = useNavigate();

    const saveCompany = (e) => {
        e.preventDefault();
        const company = { nit, name, address, phone }
        CompanyService.createCompany(company).then((Response) => {
            console.log(Response.data);
            navigate('/companys');
        }).catch(error => {
            console.log(error)
        })

    }
    const cancelCompany = (e) => {
       
            navigate('/companys');
       
    }

    return (
        <div className='container'>
            <div className='row'>
                <div className='card col-md-6 offset-md-3 offset-md-3'>
                    <hr></hr>
                    <h2 className='text-center'>Register company</h2>
                    <div className='card-body'></div>
                    <form>
                        <div className='form-group mb-2'>
                            <label className='form-label'>Nit</label>
                            <input
                                type='text'
                                placeholder='enter your nit'
                                name='nit'
                                className='form-control'
                                value={nit}
                                onChange={(e) => setNit(e.target.value)}
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
                            <label className='form-label'>address</label>
                            <input
                                type='text'
                                placeholder='enter your address'
                                name='address'
                                className='form-control'
                                value={address}
                                onChange={(e) => setAddres(e.target.value)}
                            />
                        </div>
                        <div className='form-group mb-2'>
                            <label className='form-label'>Phone</label>
                            <input
                                type='text'
                                placeholder='enter your name'
                                name='phone'
                                className='form-control'
                                value={phone}
                                onChange={(e) => setPhone(e.target.value)}
                            />
                        </div>
                        
                        <button className='btn btn-success' onClick={(e) => saveCompany(e)} >Save</button>
                        &nbsp;&nbsp;
                        <button className='btn btn-danger' onClick={(e) => cancelCompany(e)} >Cancel</button>
                        
                        
                    </form>
                </div>
            </div>
        </div>
    )
}

export default RegisterCompanyComponent;
