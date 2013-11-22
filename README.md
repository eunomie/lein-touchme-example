# lein-touchme-example

Project example for [touchme](https://github.com/sogilis/touchme)

## Installation

`git clone git@github.com/sogilis/lein-touchme-example`

## Usage

```
cd lein-touchme-example
lein repl
=> (load "lein_touchme_example/template")
```

Browse to http://localhost:8080 and see the page. Modify the file
`resources/template.html` reload the page and see... nothing
changed.

Now, launch `touchme`

```
lein touchme
```

Update the template file and reload. And see the page is updated!

See the file `project.clj` which contains two examples of configuration.

## License

Copyright © 2013 Sogilis

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
