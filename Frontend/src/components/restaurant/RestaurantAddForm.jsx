import React, { useState } from "react";
import axios from "axios";

export const RestaurantAddForm = () => {

    const [restaurant, setRestaurant] = useState({
        name : '',
        addressSi : '',
        addressGu : '',
        addressDong : ''
    })

    const inputChanged = (event) => {
        setRestaurant({...restaurant, [event.target.name] : event.target.value});
    }
    const handleSubmit = event => {
        event.preventDefault();

        axios.post("http://localhost:8080/api/restaurants", {
            name : restaurant.name,
            addressSi : restaurant.addressSi,
            addressGu : restaurant.addressGu,
            addressDong : restaurant.addressDong,
            isConfirmed : "N"
        })
        .then(function (response) {
             // response  
        }).catch(function (error) {
            // 오류발생시 실행
        }).then(function() {
            // 항상 실행
        });
        
    }

    return (
        <form onSubmit={handleSubmit}>
            <input type="text" name="name" onChange={inputChanged} value={restaurant.name} placeholder="맛집 이름을 입력해 주세요."></input><br/>
            <input type="text" name="addressSi" onChange={inputChanged} value={restaurant.addressSi} placeholder="시를 입력해 주세요."></input><br/>
            <input type="text" name="addressGu" onChange={inputChanged} value={restaurant.addressGu} placeholder="구를 입력해 주세요."></input><br/>
            <input type="text" name="addressDong" onChange={inputChanged} value={restaurant.addressDong} placeholder="동을 입력해 주세요."></input><br/>
            <input type="submit" value="Press me"></input>
        </form>
    )
}

export default RestaurantAddForm;