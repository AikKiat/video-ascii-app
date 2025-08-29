import { useState, ChangeEvent } from "react";
import "../styles/file_upload_component.css"

export default function FileUpload() {
    const [file, setFile] = useState(null);
    const [fileStatus, setFileStatus] = useState("idle");
  

    function handleFileChange(event) {
      if (event.target.files) {
        setFile(event.target.files[0]); //first element in the files array
      }
    }

    return (
      <div className="file_upload_component">

        <span id="title_box">Upload a File</span>

        <input type="file" onChange={handleFileChange} id="input_button"/>
        {/* Choosing a file */}
        {file && (
          <div id="file_details">
              <p>File Name: {file.name}</p>
              <p>File Size: {(file.size / 1024).toFixed(2) /*toFixed returns to number of decimal places*/} KB</p> 
              <p>Type: {file.type}</p>
          </div>
          )}
          {/* Uploading the file*/}
          {file && fileStatus !== "uploading" && (
            <button id="upload_button">Upload File!</button>
          )}
      </div>
    );
}
