import  React, { useState } from 'react';
import { styled } from '@mui/material/styles';
import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import Collapse from '@mui/material/Collapse';
import Avatar from '@mui/material/Avatar';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import { red } from '@mui/material/colors';
import FavoriteIcon from '@mui/icons-material/Favorite';
import ChatIcon from '@mui/icons-material/Chat';
import { Link } from 'react-router-dom';
import { Alert, Button, InputAdornment, OutlinedInput, Snackbar } from '@mui/material';

const ExpandMore = styled((props) => {
  const { expand, ...other } = props;
  return <IconButton {...other} />;
})(({ theme }) => ({
  marginLeft: 'auto',
  transition: theme.transitions.create('transform', {
    duration: theme.transitions.duration.shortest,
  }),
  variants: [
    {
      props: ({ expand }) => !expand,
      style: {
        transform: 'rotate(0deg)',
      },
    },
  ],
}));

const gradient={
    background: "linear-gradient(322deg, rgba(131,58,180,1) 0%, rgba(181,25,25,0.5858718487394958) 86%, rgba(227,146,32,1) 100%)"
};




function PostForm(props){
    const {username,userId,refreshPosts}=props;
    const [text,setText]=useState("");
    const [title,setTitle]=useState("");
    const [isSent,setIsSent]=useState(false);
    

    const savePost = () =>{
        fetch('posts', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                title : title,
                text : text,
                userId : userId,
            }), 
          })
          .then(res => res.json)
          .catch(err => console.log("error"))
    }
  const handleSubmit=()=>{
    savePost();
    setIsSent(true);
    setTitle("");
    setText("");
    refreshPosts();
  };
  const handleTitle=(value)=>{
    setTitle(value);
  };
  const handleText=(value)=>{
    setText(value);
  };
  const handleToClose = (event, reason) => {
    if ("clickaway" == reason) return;
    setIsSent(false);
};



    return (
        <div>
            <Snackbar
                open={isSent}
                autoHideDuration={5000}
                onClose={handleToClose}
            >
                <Alert onClose={handleToClose} severity='success'>This is a success message!</Alert>
            </Snackbar>
        <Card sx={{ width: 800,  margin:'25px 0 25px 0'}}>
        <CardHeader
          avatar={
            
            <Link style={{
                textDecoration:"none", color:"white"}} 
                to={{pathname:"/users/"+userId}}>
            
            <Avatar 
            style={gradient}
            sx={{ bgcolor: red[500], 
                }} aria-label="recipe">
              {username.charAt(0).toUpperCase()}
            </Avatar>
            </Link>
          }
          
          title={<OutlinedInput
          id='sandbox'
          multiline
          placeholder='Title'
          value={title}
          inputProps={{maxLength:25}}
          fullWidth
          onChange={(i)=>handleTitle(i.target.value)}>
          </OutlinedInput>}
        />
        
        <CardContent>
          <Typography variant="body2" sx={{ color: 'text.secondary' }}>
          {<OutlinedInput
          id='sandbox'
          multiline
          placeholder='Text'
          value={text}
          inputProps={{maxLength:250}}
          fullWidth
          onChange={(i)=>handleText(i.target.value)}
          endAdornment={
            <InputAdornment>
            <Button 
            onClick={handleSubmit}
            variant='contained'
            style={gradient}>
                Post
            </Button>
            </InputAdornment>
          }>
          </OutlinedInput>}
          </Typography>
        </CardContent>
      </Card>
      </div>
    );
    
}
export default PostForm;