import React from 'react';

const FooterCss = {
    display: "flex",
    justifyContent: "center",
    borderTopStyle: "solid",
    borderTopWidth: "1px"
}

function Footer(props) {
    return (
        <footer style={FooterCss}>
            <p>ⓒWoori FIS 개인디지털부 ReactStar 2023</p>
        </footer>
    );
}

export default Footer;