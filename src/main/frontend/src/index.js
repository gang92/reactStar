import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import {Restaurant} from "./components/Restaurant";
import {RestaurantAddForm} from "./components/RestaurantAddForm";
import {RestaurantList} from "./components/RestaurantList";
import {RestaurantSearchForm} from "./components/RestaurantSearchForm";
import {Header} from "./components/Header"

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <Header />
    <RestaurantSearchForm />
    <RestaurantList />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
