import  React from 'react';
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

function Post(props){
    const {text,title,username,userId}=props;
    const [expanded, setExpanded] = React.useState(false);
    const [liked,setLiked]=React.useState(false);

  const handleExpandClick = () => {
    setExpanded(!expanded);
  };

  const handleLikeClick=()=>{
    setLiked(!liked);
  };


    return (
        <Card sx={{ width: 800,  margin:'25px 0 25px 0'}}>
        <CardHeader
          avatar={
            
            <Link style={{textDecoration:"none", color:"white"}} to={{pathname:"/users/"+userId}}><Avatar sx={{ bgcolor: red[500] }} aria-label="recipe">
              {username.charAt(0).toUpperCase()}
            </Avatar>
            </Link>
          }
          
          title={title}
        />
        
        <CardContent>
          <Typography variant="body2" sx={{ color: 'text.secondary' }}>
            {text}
          </Typography>
        </CardContent>
        <CardActions disableSpacing>
          <IconButton aria-label="add to favorites"
          onClick={handleLikeClick}
          >
            <FavoriteIcon style={liked?{color:"red"}:null} />
          </IconButton>
          <ExpandMore
            expand={expanded}
            onClick={handleExpandClick}
            aria-expanded={expanded}
            aria-label="show more"
          >
            <ChatIcon/>
          </ExpandMore>
        </CardActions>
        <Collapse in={expanded} timeout="auto" unmountOnExit>
          <CardContent>
            <Typography sx={{ marginBottom: 2 }}>Method:</Typography>
            <Typography sx={{ marginBottom: 2 }}>
              Heat 1/2 cup of the broth in a pot until simmering, add saffron and set
              aside for 10 minutes.
            </Typography>
            <Typography sx={{ marginBottom: 2 }}>
             continue
            </Typography>
            <Typography sx={{ marginBottom: 2 }}>
             continue
            </Typography>
            <Typography>
              Set aside off of the heat to let rest for 10 minutes, and then serve.
            </Typography>
          </CardContent>
        </Collapse>
      </Card>
    );
    
}
export default Post;