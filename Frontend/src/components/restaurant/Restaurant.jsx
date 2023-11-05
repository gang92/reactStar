///** @jsxImportSource @emotion/react */
//import { jsx, css } from "@emotion/react";

export const Restaurant = (props) => {
    // const containerStyle = css`
    //     border: solid 1px #aaa;
    //     border-radius: 20px;
    //     padding: 8px;
    //     margin: 8px;
    //     display: flex;
    //     align-items: center;
    //     cursor: pointer; /* 마우스 커서를 포인터로 변경 */
    // `;

    // const titleStyle = css`
    //     margin: 0;
    //     color: #aaa;
    // `;

    const { id, name, addressSi, addressGu, addressDong, onClick } = props;

    const handleClick = () => {
        if (onClick) {
            onClick(id); // 클릭 이벤트 핸들러 호출
        }
    };

    return (
        // <div css={containerStyle} onClick={handleClick}>
        //     <p css={titleStyle}>{id}</p>
        //     <p>{name}</p>
        //     <p>{addressSi}</p>
        //     <p>{addressGu}</p>
        //     <p>{addressDong}</p>
        // </div>
        <div onClick={handleClick}>
            <p>{id}</p>
            <p>{name}</p>
            <p>{addressSi}</p>
            <p>{addressGu}</p>
            <p>{addressDong}</p>
        </div>
    );
};
