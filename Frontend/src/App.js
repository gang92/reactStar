// import logo from './logo.svg';
// import './App.css';
import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

import RestaurantList from './components/restaurant/RestaurantList';
import LogIn from './components/user/logIn';
import Admin from './components/admin/admin';
import SignUp from './components/user/signUp';
import UserInfo from './components/user/userInfo';
import RestaurantAddForm from './components/restaurant/RestaurantAddForm';
import { ShowRestaurantDetail } from './components/restaurant/ShowRestaurantDetail';
import NotFound from './components/page/NotFound';

import Layout from './components/page/Layout';

import {
    BrowserRouter,
    Routes,
    Route
} from 'react-router-dom';


function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route element={<Layout />}>
                    <Route path="/" element={<RestaurantList />}/>
                    <Route path="/login" element={<LogIn />}/>
                    <Route path="/user/admin" element={<Admin />}/>
                    <Route path="/signup" element={<SignUp />}/>
                    <Route path="/user/info/:uId" element={<UserInfo />}/>
                    <Route path="/restaurant/post" element={<RestaurantAddForm />}/>
                    <Route path="/restaurant/:id" element={<ShowRestaurantDetail />}/>
                    <Route path="*" element={<NotFound />}/>
                </Route>
            </Routes>
        </BrowserRouter>
    );
}

export default App;
