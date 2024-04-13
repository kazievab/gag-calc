import { defineConfig } from "vite";
import scalaJSPlugin from "@scala-js/vite-plugin-scalajs";
import i18nextLoader from 'vite-plugin-i18next-loader';
import react from '@vitejs/plugin-react'

export default defineConfig({
  base: "/gag-calc/",
  plugins: [
    scalaJSPlugin(),
    i18nextLoader({ paths: ['./public/locales'] }),
    react()
  ]
});
