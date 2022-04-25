import React from "react";

const authors = (props) => {
    return (
        <div>
             <table>
                 <thead>
                 <tr>
                     <th>Name</th>
                     <th>Surname</th>
                     <th>Country</th>
                 </tr>
                 </thead>
                 <tbody>
                 {props.authors.map((term)=>{
                     return(
                         <tr key={term.id}>
                             <td>{term.name}</td>
                             <td>{term.surname}</td>
                             <td>{term.country.name}</td>
                         </tr>
                     );
                 })}
                 </tbody>
             </table>
        </div>
    )
}

export default authors;