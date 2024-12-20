import { Outlet } from "react-router";

export default function AppLayout(){
    
    return(
        <>
            <div className="flex flex-col   h-3/4">m ,   
                <div className="flex flex-row bg-pink-300 justify-between">
                    <header className="flex justify-center items-center bg-orange-100">
                        <h1 className="italic">Todo Manager.io</h1>
                    </header>
                    <div className="flex flex-row group  bg-blue-400 ">
                        <div className="m-5 p-2 cursor-pointer  group-hover:bg-blue-600 ">Sign-In</div>
                        <p className="m-5 p-2 cursor-pointer  hover:bg-blue-600">Profile</p>
                    </div>
                </div>
            </div>
               <Outlet/>
        </>
    )
}