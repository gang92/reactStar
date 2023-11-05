import React, { useState } from "react";
import axios from "axios";
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

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

    const Width = {
        width:"30%",
        align:"left"
    }

    return (
        <div>
            <h2>맛집 신청하기</h2>
            <div>
                <form onSubmit={handleSubmit}> 
                    <Container style={Width}>
                        <Row>
                            <Col>
                                <label>이름</label>
                            </Col>
                            <Col>
                                <input type="text" name="name" onChange={inputChanged} value={restaurant.name} placeholder="맛집 이름을 입력해 주세요."></input><br/>
                            </Col>
                        </Row>
                        <Row>
                            <Col>
                                <label>시</label>
                            </Col>
                            <Col>
                                <input type="text" name="addressSi" onChange={inputChanged} value={restaurant.addressSi} placeholder="시를 입력해 주세요."></input><br/>
                            </Col>
                        </Row>
                        <Row>
                            <Col>
                                <label>동</label>
                            </Col>
                            <Col>
                                <input type="text" name="addressGu" onChange={inputChanged} value={restaurant.addressGu} placeholder="구를 입력해 주세요."></input><br/>
                            </Col>
                        </Row>
                        <Row>
                            <Col>
                                <label>구</label>
                            </Col>
                            <Col>
                                <input type="text" name="addressDong" onChange={inputChanged} value={restaurant.addressDong} placeholder="동을 입력해 주세요."></input><br/>
                            </Col>
                        </Row>
                        <Row>
                            <Col>
                            </Col>
                            <Col>
                                <input type="submit" value="신청하기"></input>
                            </Col>
                        </Row>
                    </Container>
                </form>
            </div>
        </div>
    )
}

export default RestaurantAddForm;