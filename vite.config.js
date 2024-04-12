import { defineConfig } from "vite";
import scalaJSPlugin from "@scala-js/vite-plugin-scalajs";
import react from '@vitejs/plugin-react'

export default defineConfig({
  plugins: [
    scalaJSPlugin(),
    react()
  ]
});
