/** @jsxImportSource @emotion/react */
import { jsx, css } from "@emotion/react";

export const Restaurant = (props) => {

    const containerStyle = css`
        border: solid 1px #aaa;
        border-radius: 20px;
        padding: 8px;
        margin: 8px;
        display: flex;
        align-items: center;
    `;

    const titleStyle = css`
        margin: 0,
        color: "#aaa"
    `

    const {id, name, addressSi, addressGu, addressDong} = props;

    return (
        <div css={containerStyle}>
            <p css={titleStyle}>{id}</p>
            <p>{name}</p>
            <p>{addressSi}</p>
            <p>{addressGu}</p>
            <p>{addressDong}</p>
        </div>
    )
}