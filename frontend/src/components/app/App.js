
import './App.css';
import React, {Component} from "react";
import {
    Routes,
    Navigate,
    Route, Router, BrowserRouter
} from 'react-router-dom';
import Header from "../Header/header";
import Categories from "../Categories/categories";
import Countries from "../Countries/countries";
import Authors from "../Authors/authors";
import Books from "../Books/Books";
import LibraryService from "../../repository/libraryRepository";

class App extends Component{

    constructor(props) {
        super(props);
        this.state={
            categories: [],
            countries: [],
            authors: [],
            books: []
        }
    }

    render() {
        return (
            /*<Router>
                <Header/>
                <main>
                    <div className="container">
                        <Route path={"/categories"} exact render={() =>
                            <Categories categories={this.state.categories}/>}/>
                        <Route path={"/countries"} exact render={() =>
                            <Countries countries={this.state.countries}/>}/>
                        <Route path={"/authors"} exact render={() =>
                            <Authors authors={this.state.authors}/>}/>
                        <Route path={"/books"} exact render={() =>
                            <Books books={this.state.books}/>}/>
                    </div>
                </main>
            </Router>*/
            <BrowserRouter>
                <main>
                    <Header/>
                    <div className="container">
                        <Routes>
                            <Route path="/countries" exact element={<Countries countries={this.state.countries}/>}/>
                            <Route path="/authors" exact element={<Authors authors={this.state.authors}/>}/>
                            <Route path="/categories" exact element={<Categories categories={this.state.categories}/>}/>
                            <Route path="/books" exact element={<Books books={this.state.books}/>}/>
                        </Routes>
                    </div>
                </main>
            </BrowserRouter>

        );
    }

    componentDidMount() {
        this.loadCategories();
        this.loadCountries();
        this.loadAuthors();
        this.loadBooks();
    }

    loadCategories= () => {
        LibraryService.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                })
            });
    }

    loadCountries = () => {
        LibraryService.fetchCountries()
            .then((data) => {
                this.setState({
                    countries: data.data
                })
            });
    }

    loadAuthors = () => {
        LibraryService.fetchAuthors()
            .then((data)=>{
                this.setState({
                    authors: data.data
                })
            });
    }

    loadBooks = () => {
        LibraryService.fetchBooks()
            .then((data)=>{
                this.setState({
                    books: data.data
                })
            });
    }


}

export default App;
