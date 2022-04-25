import React from "react";

const categories=(props) => {
    return(
        <div>
            <h3>Categories</h3>
            <ul>
                {props.categories.map((term)=> {
                    return(
                        <li>{term}</li>
                    );
                })}
            </ul>
        </div>
    )
}

export default categories;