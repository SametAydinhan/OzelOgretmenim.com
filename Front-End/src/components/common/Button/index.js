import React from "react";
import style from "./button.module.css";

const Button = ({ styled, children, onClick }) => {
  return (
    <button
      className={`${style.button}`}
      style={styled}
      onClick={onClick}
    >
      {children}
    </button>
  );
};

export default Button;
