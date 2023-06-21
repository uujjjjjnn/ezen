import { Grid, Button, TextField } from '@mui/material';
import React, { useState } from 'react';

const AddTodo = (props) => {

  const [item, setItem] = useState({title: ""});
  const addItem = props.addItem;
  // const editItem = props.editItem;
  // const {addItem, editItem} = props;

  const onInputChange = (e) => {
    setItem({title: e.target.value});
    console.log(item);
    
  }

  const endKeyEventHandler = (e) => {
    if(e.key === 'Enter') {
      onButtonClick();
    }
  }

  const onButtonClick = () => {
    console.log(item);   
    addItem(item);
    setItem({title: ''})
  }

  return (
    <div>
      <Grid container style={{marginTop: 16}}>
        <Grid xs={11} md={11} item style={{paddingRight: 5}}>
          <TextField placeholder='Todo add...' fullWidth
            onChange={onInputChange}
            onKeyDown={endKeyEventHandler}
            value={item.value}
          />
        </Grid>
        <Grid xs={1} md={1} item>
          <Button
            fullWidth
            style={{height: '100%'}}
            color='secondary'
            variant='outlined'
            onClick={onButtonClick}
          >+</Button>
        </Grid>
      </Grid>
    </div>
  );
};

export default AddTodo;