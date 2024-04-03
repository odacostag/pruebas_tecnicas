import React, { useState } from 'react'
import CompanyService from '../sevices/CompanyService';
import { useNavigate } from 'react-router-dom';

export const LoginComponent = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    const validateUser = (e) => {
        e.preventDefault();
        
        CompanyService.validateUser(email,password).then((Response) => {
            
            console.log(Response.data);

            if (Response.data.statusCode === 200) {
                navigate('/companys');
            }else{
                alert(Response.data.message )
            }
            
        }).catch(error => {
            console.log(error)
        })

    }

  return (
    <div className='container'>
            <div className='row'>
                <div className='card col-md-6 offset-md-3 offset-md-3'>
                    <hr></hr>
                    <h2 className='text-center'>Login</h2>
                    <div className='card-body'></div>
                    <form>
                        <div className='form-group mb-2'>
                            <label className='form-label'>Email</label>
                            <input
                                type='text'
                                placeholder='enter your email'
                                name='email'
                                className='form-control'
                                value={email}
                                onChange={(e) => setEmail(e.target.value)}
                            />
                        </div>
                        <div className='form-group mb-2'>
                            <label className='form-label'>Password</label>
                            <input
                                type='text'
                                placeholder='enter your name'
                                name='password'
                                className='form-control'
                                value={password}
                                onChange={(e) => setPassword(e.target.value)}
                            />
                        </div>
                        
                        <button className='btn btn-success' onClick={(e) => validateUser(e)} >Login</button>
                        
                    </form>
                </div>
            </div>
        </div>
  )
}

export default LoginComponent;
