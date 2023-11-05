// import logo from './logo.svg';
// import './App.css';
import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

import RestaurantList from './components/restaurant/RestaurantList';
import logIn from './components/user/login';
import admin from './components/admin/admin';
import signUp from './components/user/signup';
import userInfo from './components/user/userInfo';
import restaurantAddForm from './components/restaurant/RestaurantAddForm';
import restaurant from './components/restaurant/Restaurant';
import Header from './components/page/Header'

import {
    BrowserRouter,
    Routes,
    Route
} from 'react-router-dom';

function App() {
  return (
    <>
      <BrowserRouter>
          <Routes>
              <Route index element={<RestaurantList />}/>
              <Route path="/login" element={<logIn />}/>
              <Route path="/user/admin" element={<admin />}/>
              <Route path="/signup" element={<signUp />}/>
              <Route path="/user/info/:uId" element={<userInfo />}/>
              <Route path="/restaurant/post" element={<restaurantAddForm />}/>
              <Route path="/restaurant/:name" element={<restaurant />}/>
          </Routes>
      </BrowserRouter>
    </>
    
  );
}

export default App;
