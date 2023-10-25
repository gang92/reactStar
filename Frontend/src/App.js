// import logo from './logo.svg';
// import './App.css';
import React from 'react';

import Header from './components/page/Header'
import Footer from './components/page/Footer'
import RestaurantList from './components/restaurant/RestaurantList'
import logIn from './components/user/login'
import signUp from './components/user/signup'
import userInfo from './components/user/userInfo'
import AdminMenu from './admin/AdminMenu'

import {
    BrowserRouter,
    Routes,
    Route
} from 'react-router-dom';

function App() {
  return (
    <>
    <Header />
    <BrowserRouter>
        <Routes>
            <Route index element={<RestaurantList />}/>
            <Route path="/login" element={<logIn />}/>
            <Route path="/signup" element={<signUp />}/>
            <Route path="/user/info/:uId" element={<userInfo />}/>
        </Routes>
    </BrowserRouter>
    <Footer />
    </>
  );
}

export default App;
