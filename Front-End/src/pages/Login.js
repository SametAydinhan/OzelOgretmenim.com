import React, { useState } from "react";
import styled from "./Login.module.css";
import Button from "../components/common/Button";

const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // Burada login işlemleri yapılabilir
    console.log("Email:", email);
    console.log("Password:", password);
  };

  return (
    <div className={styled.container}>
      <form onSubmit={handleSubmit} className={styled["form-container"]}>
        <h2>Giriş Yap</h2>
        <div className={styled.inputs}>
          <label htmlFor='email'>E-posta</label>
          <input
            type='email'
            id='email'
            value={email}
            onChange={handleEmailChange}
            required
          />
        </div>
        <div className={styled.inputs}>
          <label htmlFor='password'>Şifre</label>
          <input
            type='password'
            id='password'
            value={password}
            onChange={handlePasswordChange}
            required
          />
        </div>
        <button type='submit' className={styled.button}>Giriş Yap</button>
      </form>
    </div>
  );
};

export default Login;
