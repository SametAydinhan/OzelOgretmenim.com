// src/MyContext.js
import React, { createContext, useState } from 'react';

// İlk olarak context oluşturun
export const Context = createContext();

export const ContextProvider = ({ children }) => {
  const [step, setStep] = useState(0);

  return (
    <Context.Provider value={{ step, setStep }}>
      {children}
    </Context.Provider>
  );
};
