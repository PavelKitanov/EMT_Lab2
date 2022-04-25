import React from "react";

const books = (props) => {
    return (
        <div>
            <table>
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Category</th>
                    <th>Author</th>
                    <th>availableCopies</th>
                </tr>
                </thead>
                <tbody>
                {props.books.map((term)=>{
                    return(
                        <tr key={term.id}>
                            <td>{term.name}</td>
                            <td>{term.category}</td>
                            <td>{term.author}</td>
                            <td>{term.availableCopies}</td>
                        </tr>
                    );
                })}
                </tbody>
            </table>
        </div>
    )
}

export default books;