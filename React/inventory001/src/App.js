import logo from './logo.svg';
import './App.css';
import ListCompanyComponent from './components/ListCompanyComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import RegisterCompanyComponent from './components/RegisterCompanyComponent';
import LoginComponent from './components/LoginComponent';
import ListProductComponent from './components/ListProductComponent';
import { RegisterProductComponent } from './components/RegisterProductComponent';

function App() {
  return (
    <div>
      <BrowserRouter>
        <HeaderComponent/>
        <div className='container'>
          <Routes>
            <Route exact path='/' element={<LoginComponent />}></Route>
            <Route  path='/companys' element={<ListCompanyComponent />}></Route>
            <Route  path='/register-company' element={<RegisterCompanyComponent />}></Route>
            <Route  path='/list-product' element={<ListProductComponent />}></Route>
            <Route  path='/register-product' element={<RegisterProductComponent />}></Route>
            
          </Routes>
        </div>
        <FooterComponent/>
      </BrowserRouter>
    </div>
  );
}

export default App;
