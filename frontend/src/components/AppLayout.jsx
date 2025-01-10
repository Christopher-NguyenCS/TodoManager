import { Outlet, NavLink } from "react-router";
import ProjectModal from "./ProjectModal";

export default function AppLayout(){
    
    return(
        <>
            <div className="flex flex-col ">   
                <header className="flex flex-row bg-pink-300 justify-between">
                    <nav className="flex justify-center items-center bg-orange-100">
                        <div className="border-2 border-cyan-200 m-2 p-5 hover:bg-orange-200 cursor-pointer">
                            <h1 className="italic">Todo Manager.io</h1>
                        </div>
                        <ProjectModal/>
                    </nav>
                    <nav className="flex flex-row group  bg-blue-400 border-4 border-orange-700">
                        <p className="flex justify-center items-center m-2 p-2  cursor-pointer  hover:bg-blue-600  w-full hover:border-2 border-red-950">Sign-In</p>
                        <p className="flex justify-center m-2 p-2 items-center cursor-pointer  hover:bg-blue-600 hover:border-2 border-red-950">Profile</p>
                    </nav>
                </header>
            </div>
            <div className="flex  bg-purple-400 border-2 border-solid border-blue-950 mt-5 ">
                <div className="bg-red-400 md:w-1/12 md:mr-5 h-screen">
                    <nav>
                        <ul className="p-5">
                            <li className=" flex justify-center items-center  p-5 hover:border-2">
                                <NavLink to="/">Home</NavLink>
                            </li>
                            <li className="flex justify-center items-center  p-5 hover:border-2">
                                <NavLink to="/projects">Projects</NavLink>
                            </li>
                        </ul>
                    </nav>
                </div>
               <Outlet/>
            </div>
        </>
    )
}