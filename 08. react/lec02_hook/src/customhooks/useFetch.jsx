import React from 'react';
import { useState, useEffect } from 'react';

export function useFetch(baseUrl, initialType) {

  const [data, setData] = useState('');

  const fetchUrl = (type) => {
    fetch(baseUrl + type)
      .then(res => res.json())
      .then(res => setData(res));
  }

  useEffect(() => {
    fetchUrl(initialType)
  }, []);

  return {data, fetchUrl};
};