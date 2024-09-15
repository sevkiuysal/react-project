import React,{useState,useEffect} from "react";
import ReactDOM from 'react-dom/client';

function Post(){

    const [postList,setPostList]=useState([]);
    const [isLoaded,setIsLoaded]=useState(false);
    const [error,setError]=useState(null);
    
    useEffect(()=>{
        fetch("/posts")
        .then(res=> res.json())
        .then(
        (result)=>{
            setPostList(result);
            setIsLoaded(true);
        },
        (error)=>{
            console.log(error);
            setError(error);
            setIsLoaded(true);
        })
    },[])
    if(error){
        return <div>Error!!!</div>;
    } else if(!isLoaded){
        return <div>Loading....</div>;
    } else{
        return (
           <ul>
            {
                postList.map(post =>
                    (<li key={post.id}>
                        {post.text} {post.title}
                    </li>)
                )
            }
           </ul>
        );
    }
}
export default Post;