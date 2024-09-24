import React from "react";
import { Link } from "react-router-dom";
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import styled from 'styled-components';


function Navbar(){
    let userId=5;

    return (
        <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static">
        <Toolbar>
          <IconButton
            size="large"
            edge="start"
            color="inherit"
            aria-label="menu"
            sx={{ mr: 2 }}
          >
            <MenuIcon />
          </IconButton>
         
          <Typography style={{textAlign:"left"}}  variant="h6" component="div" sx={{ flexGrow: 1 }}>
          <Link style={{textDecoration:"none", color:"white"}} to="/">Home</Link>
          </Typography>
          <Typography  style={{textAlign:"right"}} variant="h6" component="div" sx={{ flexGrow: 1 }}>
          <Link style={{textDecoration:"none", color:"white"}} to={{pathname:"/users/"+userId}}>User</Link>
          </Typography>
         
        </Toolbar>
      </AppBar>
    </Box>
        
    )

}
export default Navbar;