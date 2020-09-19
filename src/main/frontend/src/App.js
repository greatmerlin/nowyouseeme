import React, {useState, useEffect, useCallback} from 'react';
import logo from './logo.svg';
import './App.css';
import axios from "axios";
import {useDropzone} from 'react-dropzone'


const UserProfiles = () => {

  const[UserProfiles, setUserProfiles] = useState([]);

  const fetchUserProfiles = () => {
    axios.get("http://localhost:8080/api/v1/user-profile").then(res => {
    console.log(res);
    setUserProfiles(res.data);
    });
  }

  useEffect( () => {
      fetchUserProfiles();
  }, []);

  return UserProfiles.map((userProfile, index) => {

    // for each user when we loop use the myDropzone
    return (
      <div key={index}>
        {/* TODO: Profile Image */}
        <br/>
        <br/>
        <h1>{userProfile.username}</h1>
        <p>{userProfile.userProfileId}</p>
        <br/>
        <MyDropzone {...userProfile} />
        <br/>
      </div>
    )
  })
}

function MyDropzone( {userProfileId}) {
  const onDrop = useCallback(acceptedFiles => {
    // Do something with the files
    const file = acceptedFiles[0];
    console.log(file);
    const formData = new FormData();
    formData.append("file", file); // need to be the same as the file at the uploadUserProfileImage Method, request Param

    axios.post(`http://localhost::8080/api/v1/userprofile/${userProfileId}/image/upload`, 
    formData, 
    {
      headers: {
        "Content-Type" : "multipart/form-data"
      }
      
    }).then(() => {
        console.log("file uploaded successfully")
      }).catch(err => {
        console.log(err);
      });

     // the path from POSTMapping
  }, [])
  const {getRootProps, getInputProps, isDragActive} = useDropzone({onDrop})

  return (
    <div {...getRootProps()}>
      <input {...getInputProps()} />
      {
        isDragActive ?
          <p>Drop the image here ...</p> :
          <p>Drag 'n' drop image, or click to select image</p>
      }
    </div>
  )
}

function App() {
  return (
    <div className="App">
        <UserProfiles />
    </div>
  );
}

export default App;
