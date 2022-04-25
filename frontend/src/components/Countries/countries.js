import React from "react";

const countries = (props) => {
    return (
        <div>
            <table>
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Continent</th>
                </tr>
                </thead>
                <tbody>
                {props.countries.map((term)=>{
                    return(
                        <tr key={term.id}>
                            <td>{term.name}</td>
                            <td>{term.continent}</td>
                        </tr>
                    );
                })}
                </tbody>
            </table>
        </div>
    )
}

export default countries;