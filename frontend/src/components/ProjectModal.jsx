import { useState } from "react";



export default function ProjectModal (){
    const [onModal, setOnModal] = useState(false);

    const handleModal = () =>{
        console.log(onModal);
        if(!onModal){
            setOnModal(true);
        }
        else{
            setOnModal(false);
        }
    }

    return(
        <>
            
                <button 
                    
                    className="flex justify-center items-center rounded-lg border-4 border-transparent bg-cyan-200 m-2 p-2 hover:bg-cyan-300 cursor-pointer" 
                    onClick={handleModal}
                >
                    Create Project

                </button>
            
            {onModal && 
                <section className=" fixed inset-0 flex justify-center items-center bg-gray-700 bg-opacity-60 z-50" onClick={handleModal}>
                    <div className=" border-4 border-red-600 bg-gray-100 p-4 rounded-lg shadow-lg z-60 w-full max-w-lg md:h-[700px]" onClick={(e) => e.stopPropagation()}>
                        <form className="flex justify-center flex-col p-1s border-4">
                            <div className="flex justify-end items-end border-2 text-red-700 font-extrabold hover:text-red-500">
                                <button> X </button>
                            </div>
                            <label className="ml-5 md:text-xl">Title:</label>
                            <input type="text" placeholder="Project Title" className="mt-0 m-5 p-5 shadow-lg w-auto rounded-lg"/>
                            <label className="ml-5 md:text-xl">Date:</label>
                            <input type="date" placeholder="Date" className=" mt-0 m-5 p-5 w-auto shadow-lg rounded-lg"/>
                            <label className="ml-5 md:text-xl">Description:</label>
                            <textarea name="description" id="project_description" className="block w-auto h-[300px]  resize-none mt-0 m-5 p-2.5 shadow-lg rounded-lg"></textarea>
                        </form>
                    </div>
                </section>
            }
        </>
    )
}