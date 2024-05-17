import React, { useState } from "react";
import styled from "./SignUp.module.css";
import Button from "../components/common/Button";
import { Link } from "react-router-dom";

const SignUp = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [error, setError] = useState("");

  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleConfirmPasswordChange = (e) => {
    setConfirmPassword(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (password !== confirmPassword) {
      setError("Şifreler uyuşmuyor!");
      return;
    }
    setError("");
    console.log("Email:", email);
    console.log("Password:", password);
  };

  return (
    <div className={styled.container}>
      <form onSubmit={handleSubmit} className={styled["form-container"]}>
        <h2>Kayıt Ol</h2>
        <p>Zaten bir hesabınız varsa aşağıdaki linkten giriş yapın</p>

        <Link to='/login' className={styled.register}>
            Buradan Giriş Yap!
          </Link>
        {error && <p className={styled.error}>{error}</p>}
        <div className={styled.inputs}>
          <label htmlFor='email'>E-posta</label>
          <input
            type='email'
            id='email'
            value={email}
            onChange={handleEmailChange}
            required
            placeholder="E-posta adresini giriniz."
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
            placeholder="Şifrenizi girin"
          />
        </div>
        <div className={styled.inputs}>
          <label htmlFor='confirmPassword'>Şifreyi Onayla</label>
          <input
            type='password'
            id='confirmPassword'
            value={confirmPassword}
            onChange={handleConfirmPasswordChange}
            required
            placeholder="Şifreyi onaylayın"
          />
        </div>
        <button type='submit' className={styled.button}>Kayıt Ol</button>
      </form>
    </div>
  );
};

export default SignUp;
