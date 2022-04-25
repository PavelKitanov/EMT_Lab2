import axios from "../custom-axios/axios";

const LibraryService ={

    fetchBooks: () => {
        return axios.get("/books")
    },
    fetchAuthors: () => {
        return axios.get("/authors")
    },
    fetchCountries: () => {
        return axios.get("/countries")
    },
    fetchCategories: () => {
        return axios.get("/categories")
    }
}

export default LibraryService;