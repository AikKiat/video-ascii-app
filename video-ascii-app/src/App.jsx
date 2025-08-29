import { useState } from "react";
import "./styles/App.css"
import FileUpload from "./components/File_Upload";
import Header from "./components/Header";
import AsciiDisplayScreen from "./components/Ascii_Display_Screen";

function App() {
  const [count, setCount] = useState(0);

  return (
    <div className="App">
      <Header></Header>
      <AsciiDisplayScreen></AsciiDisplayScreen>
      <FileUpload></FileUpload>
    </div>
  );
}

export default App;
