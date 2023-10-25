import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
// import {Restaurant} from "./components/restaurant/Restaurant";
// import {RestaurantAddForm} from "./components/restaurant/RestaurantAddForm";
// import {RestaurantList} from "./components/restaurant/RestaurantList";
// import {RestaurantSearchForm} from "./components/restaurant/RestaurantSearchForm";
// import {Header} from "./components/page/Header"
// import { ShowRestaurantDetail } from './components/restaurant/ShowRestaurantDetail';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <React.StrictMode>
        {/* <Header />
        <RestaurantSearchForm />
        <RestaurantList /> 
        <NaverMap /> */}
        <App />
    </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
