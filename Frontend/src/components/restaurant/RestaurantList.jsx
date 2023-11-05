import { useEffect, useState } from "react";
import {Restaurant} from "./Restaurant";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

const Table = {
    border: "1px solid black"
}

const RestaurantList = (props,{children}) => {
    const [restaurants, setRestaurants] = useState([]);
    const [selectedRestaurantId, setSelectedRestaurantId] = useState(null);
    const navigate = useNavigate() ;

    useEffect(() => {
        axios.get("http://localhost:8080/api/restaurants").then((res) => {setRestaurants(res.data);
        console.log(res.data);
        })
    }, []);
    
    const handleRestaurantClick = (restaurantId) => {
        // console.log("Restaurant clicked with ID:", restaurantId);
        setSelectedRestaurantId(restaurantId);
      };

      
      return (
        <div>
          <Container>
            <Row style={Table}>
              <Col style={Table}>번호</Col>
              <Col style={Table}>이름</Col>
              <Col style={Table}>주소</Col>
            </Row>
            {restaurants.map((restaurant) => (
              <Restaurant
                key={restaurant.id}
                id={restaurant.id}
                name={restaurant.name}
                addressSi={restaurant.addressSi}
                addressGu={restaurant.addressGu}
                addressDong={restaurant.addressDong}
                onClick={() => navigate(`/restaurant/${restaurant.id}`)}
              />
            ))}
          </Container>
        </div>
      );
    };

export default RestaurantList;