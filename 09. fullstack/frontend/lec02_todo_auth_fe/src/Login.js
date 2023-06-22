import { Button, Container, Grid, TextField, Typography } from '@mui/material';
import React from 'react';
import { Link } from 'react-router-dom';
import { signin } from './service/ApiService';

const Login = () => {

  const handleSubmit = (e) => {
    e.preventDefault();
    const data = FormData(e.target);
    const username = data.get("username");
    const password = data.get("password");
    signin({username: username, password: password})
  }


  return (
    <Container component="main" maxWidth="xs" style={{ marginTop: "8%" }}>
      <Grid container spacing={2}>
        <Grid item xs={12}>
          <Typography component="h1" variant="h5">
            로그인
          </Typography>
        </Grid>
      </Grid>
      <form noValidate onSubmit={handleSubmit}>
        {" "}
        {/* submit 버튼을 누르면 handleSubmit이 실행됨. */}
        <Grid container spacing={2}>
          <Grid item xs={12}>
            <TextField
              variant="outlined"
              required
              fullWidth
              id="username"
              label="아이디"
              name="username"
              autoComplete="username"
            />
          </Grid>
          <Grid item xs={12}>
            <TextField
              variant="outlined"
              required
              fullWidth
              name="password"
              label="패스워드"
              type="password"
              id="password"
              autoComplete="current-password"
            />
          </Grid>
          <Grid item xs={12}>
            <Button type="submit" fullWidth variant="contained" color="primary">
              로그인
            </Button>
          </Grid>
          <Grid item>
            <Link to="/signup" variant="body2">          
            계정이 없습니까? 여기서 가입 하세요.
            </Link>
          </Grid>
        </Grid>
      </form>
    </Container>
  );
};

export default Login;