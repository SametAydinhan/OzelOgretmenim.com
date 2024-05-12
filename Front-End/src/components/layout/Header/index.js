import React from "react";
import Button from "../../common/Button";
import styled from "./header.module.css";
import { Link } from "react-router-dom";

const Header = () => {
  return (
    <nav className={styled.navbar}>
      <div className={styled["left-side"]}>
        <h1>Özel Ders</h1>
        <ul>
          <li>
            <a href='#'>Ana Sayfa</a>
          </li>
          <li>
            <a href='#'>İlanlar</a>
          </li>
          <li>
            <a href='#'>Hakkımızda</a>
          </li>
        </ul>
      </div>
      <div className={styled["right-side"]}>
        <Button
          styled={{
            backgroundColor: "white",
            color: "#3898F1",
            border: "1px solid #3898F1",
            marginRight: "5px",
          }}
        >
          <Link className={styled.border} to='/login'>
            Giriş Yap
          </Link>
        </Button>
        <Button styled={{ border: "1px solid #3898F1" }}>
          <Link className={styled.fill} to='/signup'>
            Kayıt Ol
          </Link>
        </Button>
      </div>
    </nav>
  );
};

export default Header;
