use std::borrow::Borrow;
use std::iter::{Filter, Iterator};
use std::string::String;

use rand::Rng;

fn main() {
    let mut liste = generate_array(25);
    println!("{}", vec_to_string(&liste));
    liste=bulle(liste);
    println!("{}", vec_to_string(&liste));
}
//liste = bourrin(liste);
//liste = selection(liste);
//liste = bulle(liste);
//liste = insertion(liste);
// liste = quickSort(liste);

fn quickSort(mut liste: Vec<u8>) -> Vec<u8>
{
    let mut newliste = Vec::new();
    if (!liste.is_empty())
    {
        let pivot= liste.as_slice()[liste.len()-1];
        let minus = extract(&liste,|x| x.lt(pivot.borrow()));
        let magnus = extract(&liste,|x| x.gt(pivot.borrow()));
        newliste = [quickSort(minus.to_vec()),vec![pivot],quickSort(magnus.to_vec())].concat();
    }
    newliste
}

//fn extract(liste:Vec<u8>, fnc:fn(x:&u8) -> bool) -> Vec<u8>
fn extract<F>( liste:&Vec<u8>, fnc:F) -> Vec<u8>
    where F:Fn(&u8) -> bool
{
    let mut newListe = liste.to_vec().into_iter().filter(fnc).collect::<Vec<u8>>();
    newListe
}

fn insertion(liste: Vec<u8>) -> Vec<u8>
{
    let mut newListe = liste;
    for i in 0..newListe.len() {
        for j in 0..i {
            if (secondIsMinus(&newListe, i - j - 1, i - j)) {
                newListe = permutation(newListe, i - j - 1, i - j)
            }
        }
    }
    newListe
}

fn bulle(liste: Vec<u8>) -> Vec<u8>
{
    let mut newListe = liste;
    for i in 0..newListe.len() - 1 {
        for j in 0..newListe.len() - i {
            if (j < newListe.len() - 1) {
                if (secondIsMinus(&newListe, j, j + 1)) {
                    newListe = permutation(newListe, j, j + 1)
                }
            }
        }
    }
    newListe
}

fn selection(liste: Vec<u8>) -> Vec<u8>
{
    let mut newListe = liste;
    for i in 0..newListe.len() {
        let mut min = i;
        for j in i..newListe.len() {
            if (secondIsMinus(&newListe, min, j))
            {
                min = j;
            }
        }
        newListe = permutation(newListe, i, min);
    }
    newListe
}

fn bourrin(liste: Vec<u8>) -> Vec<u8>
{
    let mut newListe = liste;
    for i in 0..newListe.len() - 1 {
        for i in 0..newListe.len() - 1 {
            if (i < newListe.len() - 1) {
                if (secondIsMinus(&newListe, i, i + 1)) {
                    newListe = permutation(newListe, i, i + 1)
                }
            }
        }
    }
    newListe
}


fn permutation(mut liste: Vec<u8>, first: usize, second: usize) -> Vec<u8>
{
    let mut tab = liste.as_mut_slice();
    let tmp = tab[first];
    tab[first] = tab[second];
    tab[second] = tmp;
    tab.to_vec()
}


fn secondIsMinus(liste: &Vec<u8>, first: usize, second: usize) -> bool
{
    if liste.get(first) > liste.get(second) {
        return true;
    }
    false
}


fn vec_to_string(liste: &Vec<u8>) -> String
{
    let mut buff = String::new();
    liste.iter().for_each(|x| {
        buff.push_str(&x.to_string());
        buff.push_str(",")
    });
    buff
}

fn generate_array(size: u8) -> Vec<u8>
{
    let mut liste = Vec::new();
    for num in 0..size
    {
        liste.push(rand::thread_rng().gen::<u8>())
    }
    liste
}