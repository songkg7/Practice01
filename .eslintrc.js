// .eslintrc.js

module.exports = {
  parserOptions: {
    ecmaVersion: 12,
  },
  parser: '@typescript-eslint/parser',

  env: {
    browser: true,
    es6: true,
    node: true,
    // jquery 개발환경 허용
    jquery: true,
  },
  globals: {
    _: false,
  },
  extends: [
    'airbnb-base',
    'plugin:@typescript-eslint/eslint-recommended',
    'prettier/react',
    'eslint:recommended',
    'plugin:prettier/recommended',
  ],
  plugins: ['import', 'html', '@typescript-eslint'],
  rules: {
    'prettier/prettier': [
      'error',
      {
        endOfLine: 'auto',
      },
    ],
    // "off" or 0 - turn the rule off
    // "warn" or 1 - turn the rule on as a warning (doesn’t affect exit code)
    // "error" or 2 - turn the rule on as an error (exit code is 1 when triggered)
    // "no-var": 0,
    // 'linebreak-style': 0,
    'no-console': 0,
    'no-plusplus': 0,
    'no-shadow': 0,
    'vars-on-top': 0,
    'no-underscore-dangle': 0, // var _foo;
    'comma-dangle': 0,
    'func-names': 0, // setTimeout(function () {}, 0);
    'prefer-arrow-callback': 0, // setTimeout(function () {}, 0);
    'prefer-template': 0,
    'no-nested-ternary': 0,
    'max-classes-per-file': 0,
    'arrow-parens': ['error', 'as-needed'], // a => {}
    'no-restricted-syntax': [0, 'ForOfStatement'],
    'no-param-reassign': ['error', { props: false }],
    'import/no-extraneous-dependencies': ['error', { devDependencies: true }],
  },
};
