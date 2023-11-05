import React from 'react';
import Nav from 'react-bootstrap/Nav';

const Text = {
    color: "white"
}

const divCss = {
    display: "flex",
    backgroundColor: "#343a40",
    justifyContent: "flex-start",
    fontSize: "1.1rem"
}

const Left = {
    width: "85%"
}

const Right = {
    width: "15%"
}

function Header(props) {
    return (
        <header>
            <div style={divCss}>
                <Nav defaultActiveKey="/" style={Left}>
                    <Nav.Item>
                        <Nav.Link eventKey="disabled" style={Text} disabled>
                            <strong>Woori 맛집 리스트</strong>
                            </Nav.Link>
                    </Nav.Item>
                    <Nav.Item>
                        <Nav.Link href="/" style={Text}>목록</Nav.Link>
                    </Nav.Item>
                    <Nav.Item>
                        <Nav.Link href="/restaurant/post" style={Text}>신청</Nav.Link>
                    </Nav.Item>
                </Nav>
                <Nav defaultActiveKey="/" style={Right}>
                    <Nav.Item>
                        <Nav.Link href="/login" style={Text}>로그인</Nav.Link>
                    </Nav.Item>
                    <Nav.Item>
                        <Nav.Link href="/signup" style={Text}>회원가입</Nav.Link>
                    </Nav.Item>
                </Nav>
            </div>
    </header>
    );
    
}

export default Header;
